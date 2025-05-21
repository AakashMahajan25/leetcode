import java.util.List;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // TC & SC is same as my solution only benefit is that it calculates rows independently

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);  

            long prev = 1;
            for (int j = 1; j <= i; j++) {
                long current = prev * (i - j + 1) / j;
                row.add((int) current);
                prev = current;
            }

            answer.add(row);
        }

        return answer;






        // My Approach TC->O(N^2) SC->O(N^2)  where N->numRows
        // List<List<Integer>> answer = new ArrayList<List<Integer>>();
        // List<Integer> firstRow = new ArrayList<>();
        // firstRow.add(1);
        // answer.add(firstRow);
        // if (numRows==1) return answer;
        // List<Integer> secondRow = new ArrayList<>();
        // secondRow.add(1);
        // secondRow.add(1);
        // answer.add(secondRow);
        // if (numRows==2) return answer;
        // for (int i=2; i<numRows; i++) {
        //     List<Integer> row = new ArrayList<>();
        //     row.add(1);
        //     for (int j=0; j<answer.get(i-1).size()-1; j++) {
        //         row.add(answer.get(i-1).get(j) + answer.get(i-1).get(j+1));
        //     }
        //     row.add(1);
        //     answer.add(row);
        // }
        // return answer;
    }
}