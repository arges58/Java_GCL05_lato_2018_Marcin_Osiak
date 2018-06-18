package com.band.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "band")
public class Band implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "band_id")
    private int band_id;

    @Column(name = "band_name")
    private String band_name;

    @OneToMany(
            mappedBy = "band",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Member> members;

    public Band() {
    }

    public Band(String band_name) {

        this.band_name = band_name;
        this.members = new ArrayList<>();
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member)
    {
        members.add(member);
        member.setBand(this);
    }
    public void removeMember(Member member)
    {
        members.remove(member);
        member.setBand(null);
    }
}
