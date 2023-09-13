package Model;

public class Situacao {
private int id;
private String status;

	public Situacao() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id_status) {
		this.id = id_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
		public String toString() {
			return status;
		}
}
