package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * AI-Driven Resume Screening System (Generics)
 * - Abstract JobRole + subclasses
 * - Generic Resume<T extends JobRole>
 * - Generic method to score resumes
 * - Wildcard method to process multiple job roles in one pipeline
 */
abstract class JobRole {
    String roleName;

    JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

/*
 * Generic Resume class: Resume is tied to a specific JobRole
 */
class Resume<T extends JobRole> {
    String candidateName;
    int experienceYears;
    List<String> skills = new ArrayList<>();
    T role;

    Resume(String candidateName, int experienceYears, T role) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.role = role;
    }

    void addSkill(String skill) {
        skills.add(skill);
    }

    public String toString() {
        return candidateName + " | Exp: " + experienceYears + " yrs | Role: " + role + " | Skills: " + skills;
    }
}

/*
 * Screening utility (generic + wildcard)
 */
class ScreeningPipeline {

    // Generic method: works for any Resume of any job role
    static <T extends JobRole> int score(Resume<T> resume) {
        int points = 0;

        // simple scoring logic
        points += resume.experienceYears * 10;     // experience weight
        points += resume.skills.size() * 5;        // skills weight

        // small role-based bonus (example)
        if (resume.role instanceof SoftwareEngineer && resume.skills.contains("Java")) points += 10;
        if (resume.role instanceof DataScientist && resume.skills.contains("Python")) points += 10;
        if (resume.role instanceof ProductManager && resume.skills.contains("Communication")) points += 10;

        return points;
    }

    // Wildcard method: can process list of any JobRole resumes together
    static void processAll(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> r : resumes) {
            int s = score(r);
            System.out.println(r);
            System.out.println("Score: " + s);

            // basic decision
            if (s >= 40) System.out.println("Result: SHORTLISTED\n");
            else System.out.println("Result: REJECTED\n");
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>("Devraj", 2, new SoftwareEngineer());
        r1.addSkill("Java");
        r1.addSkill("DSA");

        Resume<DataScientist> r2 = new Resume<>("Aman", 1, new DataScientist());
        r2.addSkill("Python");
        r2.addSkill("ML");

        Resume<ProductManager> r3 = new Resume<>("Riya", 3, new ProductManager());
        r3.addSkill("Communication");
        r3.addSkill("Roadmap");

        List<Resume<? extends JobRole>> all = new ArrayList<>();
        all.add(r1);
        all.add(r2);
        all.add(r3);

        ScreeningPipeline.processAll(all);
    }
}