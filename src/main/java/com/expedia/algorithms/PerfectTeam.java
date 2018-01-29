package com.expedia.algorithms;

import java.util.HashMap;
import java.util.Map;

public class PerfectTeam {

    public int find(
        String skills
    ) {
        int teamSize = 5;
        int teamMembers = 0;

        String splittedSkills[] = skills.split("");

        Map<String, Integer> subjectMap = getSubjectMap();

        for (int i = 0; i < splittedSkills.length; i++) {
            String skill = splittedSkills[i];
            subjectMap.put(skill, subjectMap.get(skill) + 1);
        }

        while (true) {

            for (String subject : subjectMap.keySet()) {
                int count = subjectMap.get(subject);

                if (count == 0) {
                    return teamMembers / teamSize;
                }

                subjectMap.put(subject, count - 1);
                teamMembers++;
            }
        }

    }

    private Map<String, Integer> getSubjectMap() {

        Map<String, Integer> subjectMap = new HashMap<>();
        subjectMap.put("p", 0);
        subjectMap.put("c", 0);
        subjectMap.put("m", 0);
        subjectMap.put("b", 0);
        subjectMap.put("z", 0);

        return subjectMap;
    }
}
