class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l=new ArrayList();
		l.add(new ArrayList());
		l.get(0).add(1);
		for(int i=1; i<rowIndex+1; i++)
		{
			int s=l.get(i-1).size();
			l.add(new ArrayList());
			l.get(i).add(1);
			for(int j=1; j<s; j++)
			{
				l.get(i).add(l.get(i-1).get(j-1)+l.get(i-1).get(j));
			}
			l.get(i).add(1);
		}
        return l.get(rowIndex);
    }
}
        
 