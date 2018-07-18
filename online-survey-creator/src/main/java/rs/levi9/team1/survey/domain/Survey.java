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

    @OneToOne
    private SurveyPrivacy surveyPrivacy;

    @OneToOne
    private SurveyStatus surveyStatus;

    @Future
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date surveyExpireDate;

    public Survey() {
    }

    public Survey(String surveyDescription, Set<SurveyQuestion> surveyQuestions, SurveyPrivacy surveyPrivacy, SurveyStatus surveyStatus, Date surveyExpireDate) {
        this.surveyDescription = surveyDescription;
        this.surveyQuestions = surveyQuestions;
        this.surveyPrivacy = surveyPrivacy;
        this.surveyStatus = surveyStatus;
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

    public SurveyPrivacy getSurveyPrivacy() {
        return surveyPrivacy;
    }

    public void setSurveyPrivacy(SurveyPrivacy surveyPrivacy) {
        this.surveyPrivacy = surveyPrivacy;
    }

    public SurveyStatus getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(SurveyStatus surveyStatus) {
        this.surveyStatus = surveyStatus;
    }

    public Date getSurveyExpireDate() {
        return surveyExpireDate;
    }

    public void setSurveyExpireDate(Date surveyExpireDate) {
        this.surveyExpireDate = surveyExpireDate;
    }
}
