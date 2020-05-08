package com.anz.wholesale.model;

/*import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data*/
public class EmployeeCustomExceptionSchema {
	
	
	/* @Getter @Setter */
	  private String message;
	  public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getNextActions() {
		return nextActions;
	}

	public void setNextActions(String nextActions) {
		this.nextActions = nextActions;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	private String details;
	  private String hint;
	  private String nextActions;
	  private String support;
	
	  protected EmployeeCustomExceptionSchema() {}
	  
	  public EmployeeCustomExceptionSchema(String message, String details, String hint, String nextActions,
			String support) {
		super();
		this.message = message;
		this.details = details;
		this.hint = hint;
		this.nextActions = nextActions;
		this.support = support;
	}
	  
	  
	
	
}