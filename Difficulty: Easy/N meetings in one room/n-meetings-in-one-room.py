#User function Template for python3

class meeting:
    def __init__(self, start, end, pos):
 
        self.start = start
        self.end = end
        self.pos = pos
class Solution:
    
    def maximumMeetings(self,n,start,end):
        # code here
        l = []
 
        for i in range(n):
            l.append(meeting(start[i], end[i], i))
 
        ans = self.Maxmeeting(l, n)
        return len(ans)
        
    def Maxmeeting(self,l,N):
        ans = []
 
    # Sorting of meeting according to
    # their finish time.
        l.sort(key=lambda x: x.end)
 
    # Initially select first meeting
        ans.append(l[0].pos)
 
    # time_limit to check whether new
    # meeting can be conducted or not.
        time_limit = l[0].end
 
    # Check for all meeting whether it
    # can be selected or not.
        for i in range(1, N):
            if l[i].start > time_limit:
                ans.append(l[i].pos)
                time_limit = l[i].end
                
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n = int(input())
        start = list(map(int,input().strip().split()))
        end = list(map(int,input().strip().split()))
        ob=Solution()
        print(ob.maximumMeetings(n,start,end))
# } Driver Code Ends