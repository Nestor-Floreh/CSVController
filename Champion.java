public class Champion {
    private String name;
    private String title;
    private String role;
    private double difficulty;
    private int skill;
    private boolean reworked;
    private String url;

    public Champion(String name, String title, String role, double difficulty, int skill, boolean reworked, String url) {
        this.name = name;
        this.title = title;
        this.role = role;
        this.difficulty = difficulty;
        this.skill = skill;
        this.reworked = reworked;
        this.url = url;
    }

    public static Champion fromLine(String line){
        String[] words = line.split(",");
        String name = words[0];
        String title = words[1];
        String role = words[2];
        double difficulty = Double.parseDouble(words[3]);
        int skill = Integer.parseInt(words[4]);
        boolean reworked = Boolean.parseBoolean(words[5]);
        String url = words[6];

        Champion champion = new Champion(name, title, role, difficulty, skill, reworked, url);

        return champion;
    }

    public boolean matches(String search){
        String nameSearch = this.name.toLowerCase();
        String titleSearch = this.title.toLowerCase();
        String roleSearch = this.role.toLowerCase();
        search = search.toLowerCase();

        return nameSearch.contains(search) || titleSearch.contains(search) || roleSearch.contains(search);
    }

    public String toString(){
        String frase;
        frase = this.name + "," + this.title +","+this.role+","+this.difficulty+","+this.skill+","+this.reworked+","+this.url;
        return frase;
    }
}
