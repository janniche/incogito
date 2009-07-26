package no.java.incogito.domain;

import fj.F;
import fj.data.List;
import fj.data.TreeMap;

/**
 * @author <a href="mailto:trygve.laugstol@arktekk.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
public class Schedule {
    public final Event event;
    public final List<Session> sessions;
    public final TreeMap<SessionId, UserSessionAssociation> sessionAssociations;

    public Schedule(Event event, List<Session> sessions, TreeMap<SessionId, UserSessionAssociation> sessionAssociations) {
        this.event = event;
        this.sessions = sessions;
        this.sessionAssociations = sessionAssociations;
    }

    public List<Session> getAttendingSessions() {
        return sessions.filter(new F<Session, Boolean>() {
            public Boolean f(final Session session) {
                return sessionAssociations.contains(session.id);
            }
        });
    }
}
