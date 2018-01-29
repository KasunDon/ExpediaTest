package com.expedia.algorithms;

import junit.framework.TestCase;
import org.junit.Test;

public class PerfectTeamTest extends TestCase {

    @Test
    public void testFindingOneTeam() {

        String skills = "pcmbz";
        int expectedTeams = 1;

        PerfectTeam perfectTeam = new PerfectTeam();

        int actual = perfectTeam.find(skills);
        assertEquals(expectedTeams, actual);
    }

    @Test
    public void testFindingZeroTeams() {

        String skills = "pcmpp";
        int expectedTeams = 0;

        PerfectTeam perfectTeam = new PerfectTeam();

        int actual = perfectTeam.find(skills);
        assertEquals(expectedTeams, actual);
    }

    @Test
    public void testFindingMultipleTeams() {

        String skills = "pcmpcmbbbzz";
        int expectedTeams = 2;

        PerfectTeam perfectTeam = new PerfectTeam();

        int actual = perfectTeam.find(skills);
        assertEquals(expectedTeams, actual);
    }

    @Test
    public void testFindingUniqueMembers() {

        String skills = "ppcpccmmbz";
        int expectedTeams = 1;

        PerfectTeam perfectTeam = new PerfectTeam();

        int actual = perfectTeam.find(skills);
        assertEquals(expectedTeams, actual);
    }

    @Test
    public void testFiveMemembersMustbePresentToFormATeam() {

        String skills = "ppcz";
        int expectedTeams = 0;

        PerfectTeam perfectTeam = new PerfectTeam();

        int actual = perfectTeam.find(skills);
        assertEquals(expectedTeams, actual);
    }
}