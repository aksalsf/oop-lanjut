package march12;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandling {
	
	static class Berkas {
		Path filePath;
		String fileContent;
		
		Berkas(Path filePath, String fileContent) {
			this.filePath = filePath;
			this.fileContent = fileContent;
		}
		
		public void setFilePath(Path filePath) {
			this.filePath = filePath;
		}
		
		Path getFilePath() {
			return this.filePath;
		}
		
		public void fillContent(String content) {
			this.fileContent = content;
		}
		
		String getFileContent() {
			return this.fileContent;
		}
		
		public void createFile(Path path)
		{
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File is exists!");
				//e.printStackTrace();
			}
		}
		
		public void analyzeFile(Path filePath)
		{
			System.out.print("File name:");
			System.out.println(filePath.getFileName());
			System.out.print("Parent file:");
			System.out.println(filePath.getParent());
			System.out.print("Jumlah subfolder:");
			System.out.println(filePath.getNameCount());
			System.out.print("Is absolute? ");
			System.out.println(filePath.isAbsolute());
			System.out.print("Subpath dari 0 ke 3:");
			System.out.println(filePath.subpath(0, 3));
			System.out.print("Is readable? ");
			System.out.println(Files.isReadable(filePath));
			System.out.print("Is writeable? ");
			System.out.println(Files.isWritable(filePath));
			System.out.print("Is executeable? ");
			System.out.println(Files.isExecutable(filePath));
			System.out.print("Is hidden? ");
			
			try {
				System.out.println(Files.isHidden(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print("Is same file? ");
			
			try {
				System.out.println(Files.isSameFile(filePath, filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.print("Is exists? ");
			System.out.println(Files.exists(filePath, LinkOption.NOFOLLOW_LINKS));

		}
		
		public void readFile(String filePath) {
			String  line = "",
					content = "";
			try {
				BufferedReader userPathInput = new BufferedReader(new FileReader(new File(filePath)));
				line = userPathInput.readLine();
				content = line + "\n";
				while (line != null) {
					line = userPathInput.readLine();
					if (line != null) content += line + "/n"; 
				}
				userPathInput.close();
			} catch(EOFException eofe) {
				System.out.println("No more lines to read.");
				System.exit(0); 
			} catch(IOException ioe) {
				System.out.println("Error reading file."); 
				System.exit(0);
			}
			System.out.println(content);
		}
		
		public void writeFile(Path filePath, String content) {
			BufferedWriter fileWrite;
			try {
				fileWrite = Files.newBufferedWriter( filePath
						, Charset.forName("ISO-8859-1")
						, StandardOpenOption.CREATE
						, StandardOpenOption.APPEND );
				fileWrite.write(content, 0, content.length());
				fileWrite.newLine();
				fileWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		String 	temporaryPath = "D:/Eclipse/default_workspaces/PBO Lanjut/src/march12",
				userInput = "";
		Path userPath = Paths.get(temporaryPath);
		Berkas myFile = new Berkas(userPath, userInput);
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader inputReader = new BufferedReader(inputStreamReader);
		
		System.out.print("Type the file path: ");
		try {
			userPath = Paths.get(inputReader.readLine());
			myFile.setFilePath(userPath);
			myFile.createFile(userPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Type anything: ");
		try {
			userInput = inputReader.readLine();
			myFile.fillContent(userInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		myFile.writeFile(userPath, userInput);
		myFile.analyzeFile(userPath);
		myFile.readFile(userPath.toString());
		
	}
	
}
