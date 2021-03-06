package org.drools.planner.examples.ras2012.move;

import java.util.ArrayList;
import java.util.List;

import org.drools.planner.core.move.Move;
import org.drools.planner.core.move.factory.AbstractMoveFactory;
import org.drools.planner.core.solution.Solution;
import org.drools.planner.examples.ras2012.RAS2012Solution;
import org.drools.planner.examples.ras2012.model.Route;
import org.drools.planner.examples.ras2012.model.planner.ItineraryAssignment;

public class RouteReassignmentMoveFactory extends AbstractMoveFactory {

    @Override
    public List<Move> createMoveList(@SuppressWarnings("rawtypes") Solution solution) {
        List<Move> moves = new ArrayList<Move>();
        RAS2012Solution sol = (RAS2012Solution) solution;
        for (ItineraryAssignment ia : sol.getAssignments()) {
            for (Route r : sol.getRoutes()) {
                if (ia.getRoute() != r) {
                    moves.add(new RouteReassignmentMove(ia, r));
                }
            }
        }
        return moves;
    }

}
