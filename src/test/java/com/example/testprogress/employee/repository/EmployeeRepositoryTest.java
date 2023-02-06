package com.example.testprogress.employee.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.testprogress.employee.model.Employee;
import com.example.testprogress.fixture.EmployeeFixture;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @DisplayName("Employee 객체를 저장하면 저장된 Employee 객체를 반환한다.")
    @Test
    void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
        // given
        Employee employee = createSeyheong();

        // when
        Employee savedEmployee = employeeRepository.save(employee);

        // then
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0L);
    }

    @DisplayName("저장된 모든 Employee 객체를 반환한다.")
    @Test
    void givenEmployeeList_whenFindAll_thenEmployeesList() {
        // given
        Employee dkstpgud = createSeyheong();
        Employee anpopo = createPopo();

        employeeRepository.saveAll(List.of(dkstpgud, anpopo));

        // when
        List<Employee> employees = employeeRepository.findAll();

        // then
        Assertions.assertThat(employees).hasSize(2);
    }

    @DisplayName("Employee 객체를 id로 찾으면 Employee 객체를 반환한다.")
    @Test
    void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {
        // given
        Employee dkstpgud = createSeyheong();
        Employee savedSehyeong = employeeRepository.save(dkstpgud);

        // when
        employeeRepository.findById(savedSehyeong.getId())
            .ifPresentOrElse(
                sehyeong -> {
                    // then
                    Assertions.assertThat(sehyeong).isNotNull();
                    Assertions.assertThat(sehyeong.getId()).isEqualTo(savedSehyeong.getId());
                    Assertions.assertThat(sehyeong.getFirstName()).isEqualTo(savedSehyeong.getFirstName());
                    Assertions.assertThat(sehyeong.getLastName()).isEqualTo(savedSehyeong.getLastName());
                    Assertions.assertThat(sehyeong.getEmail()).isEqualTo(savedSehyeong.getEmail());
                },
                () -> Assertions.fail("Employee 객체를 찾을 수 없습니다.")
            );

    }

    private Employee createEmploy(final String firstName, final String lastName, final String email) {
        return Employee.builder()
            .firstName(firstName)
            .lastName(lastName)
            .email(email)
            .build();
    }

    private Employee createPopo() {
        return createEmploy(EmployeeFixture.POPO_FIRST_NAME, EmployeeFixture.POPO_LAST_NAME, EmployeeFixture.POPO_EMAIL);
    }

    private Employee createSeyheong() {
        return createEmploy(EmployeeFixture.SEHYEONG_FIRST_NAME, EmployeeFixture.SEHYEONG_LAST_NAME, EmployeeFixture.SEHYEONG_EMAIL);
    }

}