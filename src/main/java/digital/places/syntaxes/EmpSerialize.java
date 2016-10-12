package digital.places.syntaxes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class EmpSerialize<E extends Serializable> implements Serializable {
		
		/**
		 * 
		 */
		private static long serialVersionUID;

		private static final String saveMe = "emps.ser";
		
		private E e;
		
		private int id;
		
		public EmpSerialize() {
			super();
			serialVersionUID = Calendar.getInstance().getTimeInMillis();
		}
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public E get() {
			return e;
		}

		public void add(E e) {
			this.e = e;
		}
		
		@Override
		public String toString() {
			return e + "." + id;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof EmpSerialize<?>) {
				EmpSerialize<?> tempe = (EmpSerialize<?>) obj;
				if (tempe.get().equals(this.get()) && tempe.getId() == this.getId())
					return true;
			}
			return false;
		}

		public synchronized void serialize() throws IOException {
			try (
				FileOutputStream fos = new FileOutputStream(".\\"+serialVersionUID+saveMe);
				ObjectOutputStream oos = new ObjectOutputStream(fos)
			){
				oos.writeObject(this);
			}
			
		}

		public EmpSerialize<?> deserialize(boolean cleanup) throws IOException, ClassNotFoundException {
			EmpSerialize<?> output = EmpSerialize.deserialize(serialVersionUID);
			if (cleanup) {
				String fileName = ".\\"+serialVersionUID+saveMe;
				File file = new File(fileName);
				if (file.exists()) file.delete();
			}
			return output;
		}
		
		private static synchronized EmpSerialize<?> deserialize(Long serial) throws IOException, ClassNotFoundException {
			EmpSerialize<?> output = null;
			try (
				FileInputStream fis = new FileInputStream(".\\"+serial+saveMe);
				ObjectInputStream ois = new ObjectInputStream(fis)
			) {
				Object obj = ois.readObject();
				if (obj instanceof EmpSerialize<?>) {
					output = (EmpSerialize<?>) obj;
				}
			}
			
			return output;
		}
}
