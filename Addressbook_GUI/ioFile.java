package Addressbook;

import java.io.*;

public class ioFile {
	File data = new File("person.dat");

	public AddressBook readFile() {
		AddressBook bookobj = new AddressBook();
		FileInputStream filein = null;
		ObjectInputStream objin = null;
		try {
			filein = new FileInputStream(data);
			objin = new ObjectInputStream(filein);
			bookobj = (AddressBook) objin.readObject();
			return bookobj;
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if (filein != null)
				try {
					filein.close();
				} catch (IOException e) {
				}
			if (objin != null)
				try {
					objin.close();
				} catch (IOException e) {
				}
		}
		return new AddressBook();
	}

	public void writeFile(AddressBook obj) {
		FileOutputStream fileout = null;
		ObjectOutputStream objout = null;
		try {
			fileout = new FileOutputStream(data);
			objout = new ObjectOutputStream(fileout);
			objout.writeObject(obj);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if (fileout != null)
				try {
					fileout.close();
				} catch (IOException e) {
				}
			if (objout != null)
				try {
					objout.close();
				} catch (IOException e) {
				}
		}
	}

}
