
public class MaxArea {
	public int maxArea(int[] height) {
		
		int max =0;
		int start =0;
		int end = height.length-1;
		
		while(start<end)
		{
			int width_current = end-start;
			int height_current = Math.min(height[start], height[end]);
			int vol = width_current*height_current;
			if(vol>max)
			{
				max = vol;
			}
			
			
			if(height[start]<height[end])
	             start++;
	             else 
	             end--;
			
		}
		
		
		
		for(int i=0; i<height.length - 1;i++)
		{
			for(int j = i+1;j < height.length ; j++)
			{
				int width_current = j-i;
				int height_current = Math.min(height[i], height[j]);
				int vol = width_current*height_current;
				if(vol>max)
				{
					vol = max;
				}
						
			}
		}
		
		
		return max;
        
    }

}
