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
import java.util.Date;

import com.example.user.dto.UserDTO;
import com.example.validator.ConstraintPatterns;
import com.example.validator.ValidPassword;
import com.example.validator.ValidationMessages;

@ValidPassword
@Entity
public class User {
    // #region id Validations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // #endregion
    private Long id;
    // #region name Validations
    @NotBlank(message = ValidationMessages.NAME_NOT_BLANK)
    @Size(max = 200, message = ValidationMessages.NAME_TOO_LONG)
    @Pattern(regexp = ConstraintPatterns.NAME_PATTERN, message = ValidationMessages.NAME_CONSTRAINTS)
    // #endregion
    private String name;
    // #region description Validations
    @Column(columnDefinition = "TEXT")
    @Size(max = 500, message = ValidationMessages.DESCRIPTION_TOO_LONG)
    // #endregion
    private String description;
    // #region password Validations
    @NotBlank
    @Size(min = 6, max = 200, message = ValidationMessages.PASSWORD_TOO_SHORT)
    @Pattern(regexp = ConstraintPatterns.PASSWORD_PATTERN, message = ValidationMessages.PASSWORD_CONSTRAINTS)
    // #endregion
    private String password;
    // #region email Validations
    @NotBlank(message = ValidationMessages.EMAIL_NOT_BLANK)
    @Email(message = ValidationMessages.EMAIL_NOT_VALID)
    // #endregion
    private String email;
    private String profileImageUrl;
    // #region phone Validations
    @Pattern(regexp = ConstraintPatterns.PHONE_PATTERN, message = ValidationMessages.PHONE_FORMAT)
    // #endregion
    private String phone;
    // #region birthDate Validations
    @NotNull(message = ValidationMessages.BIRTH_DATE_NOT_BLANK)
    @Past(message = ValidationMessages.BIRTH_DATE_INVALID)
    // #endregion
    private Date birthDate;

    // #region CONSTRUCTORS
    public User(String name, String email, Date birthDate, String password) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
    }
    // #endregion

    // #region GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    // #endregion

    public UserDTO toUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setName(this.name);
        userDTO.setEmail(this.email);
        userDTO.setBirthDate(this.birthDate);
        userDTO.setPhone(this.phone);
        userDTO.setPassword(this.password);
        userDTO.setSuccess(true);

        return userDTO;
    }
}
