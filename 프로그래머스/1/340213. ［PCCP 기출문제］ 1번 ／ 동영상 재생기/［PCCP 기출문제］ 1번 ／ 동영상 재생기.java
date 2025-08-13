class Solution {
    static int now = 0;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoLen = video_len.split(":");
        String[] opStart = op_start.split(":");
        String[] opEnd = op_end.split(":");
        String[] position = pos.split(":");
        
        int totalVedioLen = Integer.parseInt(videoLen[0])*60 + Integer.parseInt(videoLen[1]); // 비디오전체 시간(초)
        int opStartTime = Integer.parseInt(opStart[0])*60 + Integer.parseInt(opStart[1]); // 오프닝 시작 시간(초)
        int opEndTime = Integer.parseInt(opEnd[0])*60 + Integer.parseInt(opEnd[1]); // 오프닝 엔딩 시간(초)
        now = Integer.parseInt(position[0])*60 + Integer.parseInt(position[1]);
        
        for(String cmd : commands) {
            if(now >= opStartTime && now <= opEndTime) {
                skip(now, opEndTime);
            }
            switch(cmd) {
                case "next":
                    next(now, totalVedioLen);
                    if(now >= opStartTime && now <= opEndTime) {
                        skip(now, opEndTime);
                    }
                    System.out.println("now:" + now);
                    break;
                case "prev":
                    prev(now);
                    if(now >= opStartTime && now <= opEndTime) {
                        skip(now, opEndTime);
                    }
                    System.out.println("now:" + now);
                    break;
            }
            
        }
        
        String answer = "" + String.format("%02d", now / 60) + ":" + String.format("%02d", now % 60);

        return answer;
    }
    
    private static void next(int position, int totalVedioLen) {
        if(position + 10 > totalVedioLen) {
            position = totalVedioLen;
        }
        else {
            position += 10;
        }
        now = position;
        return;
        
    }
    private static void prev(int position) {
        if(position - 10 < 0) {
            position = 0;
        }
        else {
            position -= 10;
        }
        now = position;
        return;
    }
    private static void skip(int position, int opEndTime) {
        now = opEndTime;
        return;
        
    }
}