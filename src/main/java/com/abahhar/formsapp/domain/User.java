package com.abahhar.formsapp.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
     
    @Id
    @GeneratedValue
    private Integer id;
     
    private String login;
     
    private String password;
    
    //---------------------------------Navigation properties---------------------------------//
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private Role role;
    
    @OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
    private Set<SimpleAnswer> simpleAnswers;

	@OneToMany(mappedBy="user", cascade=CascadeType.REMOVE)
    private Set<ChoiceAnswer> choiceAnswers;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public Role getRole() {
        return role;
    }
 
    public void setRole(Role role) {
        this.role = role;
    }
    
    public Set<SimpleAnswer> getSimpleAnswers() {
		return simpleAnswers;
	}

	public void setSimpleAnswers(Set<SimpleAnswer> simpleAnswers) {
		this.simpleAnswers = simpleAnswers;
	}

	public Set<ChoiceAnswer> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(Set<ChoiceAnswer> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}
 
}
