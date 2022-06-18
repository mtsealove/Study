package UserReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Report> reportList = new ArrayList<>();
        for (String id : id_list) {
            reportList.add(new Report(id));
        }
        // 동일한 신고 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        for (String line : set) {
            String[] sp = line.split(" ");
            String user = sp[1];
            String damn = sp[0];

            Report r = getById(reportList, user);
            if (r != null) {
                r.damn.add(damn);
            }
        }
        for (Report r : reportList) {
            if (r.damn.size() >= k) {
                for (String pid : r.damn) {
                    Report p = getById(reportList, pid);
                    if (p != null) {
                        p.addAlert();
                    }
                }
            }
        }

        int[] answer =new int[reportList.size()];
        for (int i=0; i< reportList.size(); i++) {
            answer[i] = reportList.get(i).alert;
        }
        return answer;
    }

    // id로 검색
    private Report getById(ArrayList<Report> reports, String id) {
        for (Report report : reports) {
            if (report.id.equals(id)) {
                return report;
            }
        }
        return null;
    }

    class Report {
        String id;
        ArrayList<String> damn; // 신고한 유저
        int alert = 0; // 알림 횟수

        public Report(String id) {
            this.id = id;
            this.damn = new ArrayList<>();
        }

        public void addAlert() {
            this.alert++;
        }
    }
}
