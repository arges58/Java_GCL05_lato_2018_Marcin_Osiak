package com.band.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private int member_id;

    @Column(name = "member_name")
    private String member_name;

    @Column(name = "member_surname")
    private String member_surname;

    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Instrument> instruments  = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "band_fk")
    private Band band;

    public Member() {
    }

    public Member(int member_id, String member_name, String member_surname) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_surname = member_surname;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_surname() {
        return member_surname;
    }

    public void setMember_surname(String member_surname) {
        this.member_surname = member_surname;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public void addInstrument(Instrument instrument)
    {
        instruments.add(instrument);
        instrument.setMember(this);
    }
    public void removeInstrument(Instrument instrument)
    {
        instruments.remove(instrument);
        instrument.setMember(null);
    }
}
