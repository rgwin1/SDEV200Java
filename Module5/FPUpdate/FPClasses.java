import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//class representing a family member
public class FamilyMember {
	//first name
	private String firstName;
	//last name
	private String lastName;
	//date of birth
	private LocalDate dateOfBirth;
	//medical information
	private String medicalInfo;
	//notes about member
	private String notes;

	//get first name
	public String getFirstName() {
		return firstName;
	}
	//set first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//get last name
	public String getLastName() {
		return lastName;
	}
	//set last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//get date of birth
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	//set date of birth
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	//get medical info
	public String getMedicalInfo() {
		return medicalInfo;
	}
	//set medical info
	public void setMedicalInfo(String medicalInfo) {
		this.medicalInfo = medicalInfo;
	}

	//get notes
	public String getNotes() {
		return notes;
	}
	//set notes
	public void setNotes(String notes) {
		this.notes = notes;
	}

	//return true if fields are valid
	public boolean isValid() {
		return firstName != null && lastName != null && dateOfBirth != null;
	}

	//convert to string
	public String toString() {
		return firstName + " " + lastName + ", DOB: " + dateOfBirth;
	}
}

//class representing a family group
class Family {
	//list of members
	private List<FamilyMember> members = new ArrayList<>();
	//family name
	private String familyName;

	//add member to list
	public void addMember(FamilyMember member) {
		members.add(member);
	}
	//remove member from list
	public void removeMember(FamilyMember member) {
		members.remove(member);
	}
	//get list of members
	public List<FamilyMember> getMembers() {
		return members;
	}

	//get family name
	public String getFamilyName() {
		return familyName;
	}
	//set family name
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	//find member by first name
	public FamilyMember findMember(String name) {
		for (FamilyMember member : members) {
			if (member.getFirstName().equalsIgnoreCase(name)) {
				return member;
			}
		}
		return null;
	}

	//convert to string
	public String toString() {
		return "Family: " + familyName + ", Members: " + members.size();
	}
}

//class representing a task assigned to a family member
class Task {
	//task description
	private String description;
	//due date
	private LocalDate dueDate;
	//assigned member
	private FamilyMember assignedTo;
	//task status
	private boolean completed;

	//get description
	public String getDescription() {
		return description;
	}
	//set description
	public void setDescription(String description) {
		this.description = description;
	}

	//get due date
	public LocalDate getDueDate() {
		return dueDate;
	}
	//set due date
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	//get assigned member
	public FamilyMember getAssignedTo() {
		return assignedTo;
	}
	//set assigned member
	public void setAssignedTo(FamilyMember assignedTo) {
		this.assignedTo = assignedTo;
	}

	//return true if task is complete
	public boolean isCompleted() {
		return completed;
	}
	//set completion status
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	//convert to string
	public String toString() {
		return description + ", Due: " + dueDate + ", Assigned to: " + (assignedTo != null ? assignedTo.getFirstName() : "None");
	}
}

//class representing an event
class Event {
	//event title
	private String title;
	//event date
	private LocalDate date;
	//event time
	private LocalTime time;
	//event location
	private String location;
	//event notes
	private String notes;

	//get title
	public String getTitle() {
		return title;
	}
	//set title
	public void setTitle(String title) {
		this.title = title;
	}

	//get date
	public LocalDate getDate() {
		return date;
	}
	//set date
	public void setDate(LocalDate date) {
		this.date = date;
	}

	//get time
	public LocalTime getTime() {
		return time;
	}
	//set time
	public void setTime(LocalTime time) {
		this.time = time;
	}

	//get location
	public String getLocation() {
		return location;
	}
	//set location
	public void setLocation(String location) {
		this.location = location;
	}

	//get notes
	public String getNotes() {
		return notes;
	}
	//set notes
	public void setNotes(String notes) {
		this.notes = notes;
	}

	//convert to string
	public String toString() {
		return title + " on " + date + " at " + time + " (" + location + ")";
	}
}
