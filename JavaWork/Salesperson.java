
public class Salesperson {
	private int ID;
	private double annual_sale_amount;
	
	public Salesperson(int id, double annual)
	{
		this.ID = id;
		this.annual_sale_amount = annual;
		
	}
	
	public int Get_ID()

	{
		return this.ID;
	}
	public double Get_Annual_Sale_Amount()
	{
		return this.annual_sale_amount;
	}
	
    @Override
    public String toString() {
        return "Salespersonid=" + ID + "\n annualSales=" + annual_sale_amount + "$";
    }
}
