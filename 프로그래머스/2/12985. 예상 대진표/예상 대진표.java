class Solution
{
    public int solution(int n, int a, int b)
    {
        int from = Math.min(a,b);
        int to = Math.max(a,b);
        int i = 1;
        
        for( ; n >> i >= 1; i++){
            if(from % 2 == 1)
                from += 1;
            if(to % 2 == 1)
                to += 1;
            
            from >>= 1;
            to >>= 1;

            if(from == 0)
                from = 1;
                    
            if(from == to)
                break;
        }

        return i;
    }
}