package rs.levi9.team1.survey.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Survey extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String surveyDescription;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SurveyQuestion> surveyQuestions;

    @ManyToOne
    @JoinColumn(name = "fk_survey_user")
    private SurveyUser surveyUser;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_survey_privacy")
//    private SurveyPrivacy surveyPrivacy = new SurveyPrivacy(SurveyPrivacy.PrivacyType.PUBLIC);
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fk_survey_status")
//    private SurveyStatus surveyStatus = new SurveyStatus(SurveyStatus.SurveyStatusType.OPEN);

    @Future
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date surveyExpireDate;

    public Survey() {
    }

    public Survey(String surveyDescription, Set<SurveyQuestion> surveyQuestions, SurveyUser surveyUser, Date surveyExpireDate) {
        this.surveyDescription = surveyDescription;
        this.surveyQuestions = surveyQuestions;
        this.surveyUser = surveyUser;
//        this.surveyPrivacy = surveyPrivacy;
//        this.surveyStatus = surveyStatus;
        this.surveyExpireDate = surveyExpireDate;
    }

    public String getSurveyDescription() {
        return surveyDescription;
    }

    public void setSurveyDescription(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public Set<SurveyQuestion> getSurveyQuestions() {
        return surveyQuestions;
    }

    public void setSurveyQuestions(Set<SurveyQuestion> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }

    public SurveyUser getSurveyUser() {
        return surveyUser;
    }

    public void setSurveyUser(SurveyUser surveyUser) {
        this.surveyUser = surveyUser;
    }

//    public SurveyPrivacy getSurveyPrivacy() {
//        return surveyPrivacy;
//    }
//
//    public void setSurveyPrivacy(SurveyPrivacy surveyPrivacy) {
//        this.surveyPrivacy = surveyPrivacy;
//    }
//
//    public SurveyStatus getSurveyStatus() {
//        return surveyStatus;
//    }
//
//    public void setSurveyStatus(SurveyStatus surveyStatus) {
//        this.surveyStatus = surveyStatus;
//    }

    public Date getSurveyExpireDate() {
        return surveyExpireDate;
    }

    public void setSurveyExpireDate(Date surveyExpireDate) {
        this.surveyExpireDate = surveyExpireDate;
    }
}
