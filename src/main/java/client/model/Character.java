package client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Character implements Serializable {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("wikiUrl")
    private String wikiUrl;

    @JsonProperty("race")
    private String race;

    @JsonProperty("birth")
    private String birth;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("death")
    private String death;

    @JsonProperty("hair")
    private String hair;

    @JsonProperty("height")
    private String height;

    @JsonProperty("realm")
    private String realm;

    @JsonProperty("spouse")
    private String spouse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(name, character.name) && Objects.equals(wikiUrl, character.wikiUrl) && Objects.equals(race, character.race) && Objects.equals(birth, character.birth) && Objects.equals(gender, character.gender) && Objects.equals(death, character.death) && Objects.equals(hair, character.hair) && Objects.equals(height, character.height) && Objects.equals(realm, character.realm) && Objects.equals(spouse, character.spouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, wikiUrl, race, birth, gender, death, hair, height, realm, spouse);
    }

    public String getName() {
        return name;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public String getRace() {
        return race;
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getDeath() {
        return death;
    }

    public String getHair() {
        return hair;
    }

    public String getHeight() {
        return height;
    }

    public String getRealm() {
        return realm;
    }

    public String getSpouse() {
        return spouse;
    }
}
