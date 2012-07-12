import java.text.DateFormat;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.durasoft.HotelInfo;

public class HotelClient {
	public static void main(String[] args) 
	{
		try 
		{
			Context context = new InitialContext();
			HotelInfo info = (HotelInfo)context.lookup("HotelInformation");
			try
			{
				DateFormat dateFmt = DateFormat.getDateInstance(
						DateFormat.SHORT, Locale.US);
				System.out.println("Availability: " + 
						info.getAvailability(dateFmt.parse("06/01/2006"),
								dateFmt.parse("06/02/2007")));

				System.out.println("Availability: " + 
						info.getAvailability(dateFmt.parse("07/01/2006"),
								dateFmt.parse("07/02/2007")));

				System.out.println("Availability: " + 
						info.getAvailability(dateFmt.parse("07/01/2000"),
								dateFmt.parse("08/02/2000")));

				System.out.println("Rate: " + 
						info.getRate(dateFmt.parse("07/01/2000"),
								dateFmt.parse("08/02/2000")));

				System.out.println("Availability: " + 
						info.getAvailability(dateFmt.parse("07/01/2000"),
								dateFmt.parse("06/02/2000")));
			}
			catch(Exception e)
			{
				System.out.println("Error: " + e);
			}

		}
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
	} 
}
