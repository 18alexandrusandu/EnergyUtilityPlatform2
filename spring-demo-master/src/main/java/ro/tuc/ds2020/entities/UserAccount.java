package ro.tuc.ds2020.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserAccount {

    UserAccount()
    {

        devices=new ArrayList<Device>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    @OneToOne(fetch= FetchType.EAGER)
    private Role role;
    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name="id_user")
    private List<Device> devices;

}
