package utilsdev.model.test;

public class Entity {

	private Integer id;
    private String name;
    private String dscDescription;

    public Entity() {
    }
    
	public Entity(int id) {
    	this.id = id;
    }
	
	public Entity(String name) {
		this.name = name;
	}
	
    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Entity(int id, String name, String dscDescription) {
        this.id = id;
        this.name = name;
        this.dscDescription = dscDescription;
    }

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDscDescription() {
		return dscDescription;
	}

	public void setDscDescription(String dscDescription) {
		this.dscDescription = dscDescription;
	}
    
}
