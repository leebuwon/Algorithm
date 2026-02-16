package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20006 {
    static int n;
    static int m;
    static String[][] people;

    static class Room {
        int baseLevel;
        List<Player> players;

        public Room(int baseLevel, List<Player> players) {
            this.baseLevel = baseLevel;
            this.players = players;
        }
    }

    static class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        people = new String[n][2];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                people[i][j] = st.nextToken();
            }
        }

        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int level = Integer.parseInt(people[i][0]);
            String name = people[i][1];

            boolean flag = false;

            // 각 방마다 가장먼저들어간 사람의 레벨을 평가해야함
            // 만약 레벨이 -10 ~ +10 차이가 난다면 방을하나 새로 생성함
            // 만약 레벨이 충족하더라도 방이 가득찼을 경우 새로운 방을 만들어야함
            for (Room room : rooms) {
                // 방이 가득찼다면 continue
                if(room.players.size() >= m) {
                    continue;
                }

                if(room.baseLevel - 10 <= level && room.baseLevel + 10 >= level) {
                    room.players.add(new Player(level, name));
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                Room newRoom = new Room(level, new ArrayList<>());
                newRoom.players.add(new Player(level, name));
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if(room.players.size() >= m) {
                sb.append("Started!");
                sb.append("\n");
            } else {
                sb.append("Waiting!");
                sb.append("\n");
            }
            room.players.sort(Comparator.comparing(p -> p.name));
            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.name);
                    sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}
