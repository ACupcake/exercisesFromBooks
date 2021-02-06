import java.io.File;

public class ListFiles {
	public static void main(String[] args) {
		String filePath = args[0];
		File fileInstance = new File(filePath);

		printSubPath(fileInstance, "");
	}

	public static void printSubPath(File fileInstance, String space) {
		File[] fileList = fileInstance.listFiles();

		printFileName(fileInstance, space);
		space += " ";

		for(File currentFile: fileList) {
			String[] archivesList = currentFile.list();
			if(currentFile.isDirectory())
				printSubPath(currentFile, space);
			else
				printFileName(currentFile, space);
		}
	}

	public static void printFileName(File file, String space) {
		System.out.println(space + "|" + file.getName());
	}
}