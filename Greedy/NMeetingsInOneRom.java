class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int schedule[][] = new int[n][2];
        for(int i=0; i<n; i++){
            schedule[i][0] = start[i];
            schedule[i][1] = end[i];
        }
        Arrays.sort(schedule, (a,b)->a[1]-b[1]);
        int meetings = 0;
        int lastMeeting = -1;
        for(int i=0; i<n; i++){
            if(schedule[i][0]>lastMeeting){
                meetings+=1;
                lastMeeting = schedule[i][1];
            }
        }
        return meetings;
        
    }
}
