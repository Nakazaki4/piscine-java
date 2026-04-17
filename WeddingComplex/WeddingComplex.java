import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        if (first == null || second == null || first.isEmpty()) {
            return new HashMap<>();
        }

        Map<String, Map<String, Integer>> reviewerRanks = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : second.entrySet()) {
            String reviewerName = entry.getKey();
            List<String> preferences = entry.getValue();
            
            Map<String, Integer> ranks = new HashMap<>();
            for (int i = 0; i < preferences.size(); i++) {
                ranks.put(preferences.get(i), i);
            }
            reviewerRanks.put(reviewerName, ranks);
        }

        Queue<String> freeProposers = new LinkedList<>(first.keySet());
        
        Map<String, Integer> nextProposalIndex = new HashMap<>();
        for (String proposer : first.keySet()) {
            nextProposalIndex.put(proposer, 0);
        }

        Map<String, String> engagements = new HashMap<>();

        while (!freeProposers.isEmpty()) {
            String currentProposer = freeProposers.poll();
            List<String> proposerPrefs = first.get(currentProposer);
            
            int proposalIdx = nextProposalIndex.get(currentProposer);
            String targetReviewer = proposerPrefs.get(proposalIdx);
            
            nextProposalIndex.put(currentProposer, proposalIdx + 1);

            if (!engagements.containsKey(targetReviewer)) {
                engagements.put(targetReviewer, currentProposer);
            } 
            else {
                String currentPartner = engagements.get(targetReviewer);
                
                int currentPartnerRank = reviewerRanks.get(targetReviewer).get(currentPartner);
                int newProposerRank = reviewerRanks.get(targetReviewer).get(currentProposer);

                if (newProposerRank < currentPartnerRank) {
                    engagements.put(targetReviewer, currentProposer);
                    freeProposers.add(currentPartner);
                } else {
                    freeProposers.add(currentProposer);
                }
            }
        }

        Map<String, String> bestCouples = new HashMap<>();
        for (Map.Entry<String, String> engagement : engagements.entrySet()) {
            bestCouples.put(engagement.getValue(), engagement.getKey());
        }

        return bestCouples;
    }
}