package com.example.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

import com.example.user.validator.ConstraintPatterns;
import com.example.user.validator.ValidPassword;
import com.example.user.validator.ValidationMessages;

@ValidPassword
@Entity
public class User {
//#region id Validations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//#endregion
    private Long id;
//#region name Validations
    @NotBlank(message = ValidationMessages.NAME_NOT_BLANK)
    @Size(max=200, message = ValidationMessages.NAME_TOO_LONG)
    @Pattern(regexp = ConstraintPatterns.NAME_PATTERN,
            message = ValidationMessages.NAME_CONSTRAINTS)
//#endregion
    private String name;
//#region username Validations
    @NotBlank
//#endregion
    private String username;
//#region description Validations
    @Column(columnDefinition = "TEXT")
    @Size(max=500, message= ValidationMessages.DESCRIPTION_TOO_LONG)
    //#endregion
    private String description;
//#region password Validations
    @NotBlank
    @Size(min=6, max=200, message= ValidationMessages.PASSWORD_TOO_SHORT)
    @Pattern(   regexp = ConstraintPatterns.PASSWORD_PATTERN,
                message = ValidationMessages.PASSWORD_CONSTRAINTS)
//#endregion
    private String password;
//#region confirmPassword Validations
    @NotBlank(message = ValidationMessages.PASSWORD_NOT_BLANK)
//#endregion
    private String confirmPassword;
//#region email Validations
    @NotBlank(message = ValidationMessages.EMAIL_NOT_BLANK)
    @Email(message = ValidationMessages.EMAIL_NOT_VALID)
//#endregion
    private String email;
    private String profileImageUrl;
//#region phone Validations
    @Pattern(regexp = ConstraintPatterns.PHONE_PATTERN,
            message = ValidationMessages.PHONE_FORMAT)
//#endregion
    private String phone;
//#region birthDate Validations
    @NotNull(message = ValidationMessages.BIRTH_DATE_NOT_BLANK)
    @Past(message = ValidationMessages.BIRTH_DATE_INVALID)
//#endregion
    private LocalDate birthDate;

//#region GETTERS & SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Integer getAge() {
        if(birthDate == null)
            return 0;
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
//#endregion
}
