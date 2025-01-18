package therplanner;

public class Therapist {
  private int id;
  private String name;
  private String lastName;
  private String title;
  private String approach;
  private String bio;
  private String specialties;
  private String education;
  private String training;
  private boolean available;
  private String photo; // Add the photo property

  // Constructor
  public Therapist(int id, String name, String lastName, String title, String approach, String bio, 
                   String specialties, String education, String training, boolean available, String photo) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.title = title;
    this.approach = approach;
    this.bio = bio;
    this.specialties = specialties;
    this.education = education;
    this.training = training;
    this.available = available;
    this.photo = photo; // Initialize the photo property
  }

  // Getters and Setters
  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getLastName() {
      return lastName;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getApproach() {
      return approach;
  }

  public void setApproach(String approach) {
      this.approach = approach;
  }

  public String getBio() {
      return bio;
  }

  public void setBio(String bio) {
      this.bio = bio;
  }

  public String getSpecialties() {
      return specialties;
  }

  public void setSpecialties(String specialties) {
      this.specialties = specialties;
  }

  public String getEducation() {
      return education;
  }

  public void setEducation(String education) {
      this.education = education;
  }

  public String getTraining() {
      return training;
  }

  public void setTraining(String training) {
      this.training = training;
  }

  public boolean isAvailable() {
      return available;
  }

  public void setAvailable(boolean available) {
      this.available = available;
  }

  public String getPhoto() { // Getter for photo
      return photo;
  }

  public void setPhoto(String photo) { // Setter for photo
      this.photo = photo;
  }
}
