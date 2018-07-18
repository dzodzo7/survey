package rs.levi9.team1.survey.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SurveyQuestion extends BaseEntity {

    @NotNull
    private String text;

    @OneToMany(mappedBy = "surveyQuestion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SurveyAnswer> surveyAnswers = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "fk_survey")
    private Survey survey;

    enum QuestionType {
        SINGLE_ANSWER, MULTIPLE_ANSWERS
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<SurveyAnswer> getSurveyAnswers() {
        return surveyAnswers;
    }

    public void setSurveyAnswers(Set<SurveyAnswer> surveyAnswers) {
        this.surveyAnswers = surveyAnswers;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public SurveyQuestion() {
    }

    public SurveyQuestion(String text, Set<SurveyAnswer> surveyAnswers, QuestionType questionType) {
        this.text = text;
        this.surveyAnswers = surveyAnswers;
        this.questionType = questionType;
    }
}
