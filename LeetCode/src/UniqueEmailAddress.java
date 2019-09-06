import java.util.ArrayList;

public class UniqueEmailAddress {
	
    public int numUniqueEmails(String[] emails) {
        ArrayList<String> uniqueEmailAddresses = new ArrayList<String>();
        
        for (String emailAddress : emails) {
        	
        	String userName = emailAddress.substring(0, emailAddress.indexOf('@')) ;
        	String domainName = emailAddress.substring(emailAddress.indexOf('@')+1);
        	
        	if(userName.contains("+"))
        	{
        		userName = userName.substring(0,userName.indexOf('+'));
        		
        		if(userName.contains("."))
        		{
        			userName = userName.replace(".", "");
        		}
        		
        		if(!uniqueEmailAddresses.contains(userName + domainName))
    			{
        			uniqueEmailAddresses.add(userName + domainName);    				
    			}
        	}
		}
    	
    	return uniqueEmailAddresses.size();
    }
    
    public static void main(String[] args) {
		int count = new UniqueEmailAddress().numUniqueEmails(new String[] {"fg.r.u.uzj+o.pw@kziczvh.com","r.cyo.g+d.h+b.ja@tgsg.z.com",
				"fg.r.u.uzj+o.f.d@kziczvh.com","r.cyo.g+ng.r.iq@tgsg.z.com",
				"fg.r.u.uzj+lp.k@kziczvh.com","r.cyo.g+n.h.e+n.g@tgsg.z.com","fg.r.u.uzj+k+p.j@kziczvh.com","fg.r.u.uzj+w.y+b@kziczvh.com",
				"r.cyo.g+x+d.c+f.t@tgsg.z.com","r.cyo.g+x+t.y.l.i@tgsg.z.com","r.cyo.g+brxxi@tgsg.z.com","r.cyo.g+z+dr.k.u@tgsg.z.com",
				"r.cyo.g+d+l.c.n+g@tgsg.z.com","fg.r.u.uzj+vq.o@kziczvh.com","fg.r.u.uzj+uzq@kziczvh.com","fg.r.u.uzj+mvz@kziczvh.com",
				"fg.r.u.uzj+taj@kziczvh.com","fg.r.u.uzj+fek@kziczvh.com"});
		
				System.out.println("count: " + count);
}
		}
		
		
