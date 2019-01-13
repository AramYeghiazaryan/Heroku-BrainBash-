package am.aca.quiz_software.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="uset")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name",nullable = false)
    private String name;
    @Column(name="last_name",nullable = false)
    private String surname;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "nickname",nullable = false)
    private String nickname;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "is_admin",columnDefinition = "false")
    private boolean is_admin;
    @Column(name = "avatar_image")
    private byte[] image;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<HistoryEntity> historyList;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<ScoreEntity> scoreList;

    public UserEntity(String name, String surname, String email, String nickname, String password, boolean is_admin, byte[] image, List<HistoryEntity> historyList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.is_admin = is_admin;
        this.image = image;
        this.historyList = historyList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<HistoryEntity> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<HistoryEntity> historyList) {
        this.historyList = historyList;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", is_admin=" + is_admin +
                ", image=" + Arrays.toString(image) +
                ", historyList=" + historyList +
                '}';
    }
}
