package lti.ex8;

public class CreditCard extends BillingDetails {

	private String type;
	private String expiry;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	
	@Override
	public String toString() {
		return "Credit Card [type ="+type+",expiry "+expiry +", toString()="+super.toString()+"]";
	}
	
}
