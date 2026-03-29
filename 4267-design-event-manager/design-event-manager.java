class Pair {
    int id;
    int pr;
    Pair(int id, int pr) {
        this.id = id;
        this.pr = pr;
    }
}

class EventManager {
    PriorityQueue<Pair> pq;
    Map<Integer, Integer> map;
    public EventManager(int[][] events) {
            pq = new PriorityQueue<>((a, b)-> {
            int compare = Integer.compare(b.pr, a.pr);
            if (compare != 0) return compare;
            return Integer.compare(a.id, b.id);
        });
        map = new HashMap<>();
        for (int[] event: events) {
            pq.offer(new Pair(event[0], event[1]));
            map.put(event[0], event[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new Pair(eventId, newPriority));
    }
    
    public int pollHighest() {
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int pr = pair.pr; int id = pair.id;
            if (map.containsKey(id) && map.get(id) == pr) {
                map.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */