package com.band.entity;


import javax.persistence.*;

@Entity
@Table(name = "instrument")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instrument_id")
    private int instrument_id;

    @Column(name = "instrument_name")
    private String instrument_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_fk")
    private Member member;

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
