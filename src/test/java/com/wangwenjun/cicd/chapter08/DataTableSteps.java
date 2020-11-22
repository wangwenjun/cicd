package com.wangwenjun.cicd.chapter08;

import com.wangwenjun.cicd.chapter07.FullNameSplit;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DataTableSteps
{
    private final List<Name> actuallyNames = new ArrayList<>();

    private List<String> nameDataTable;

    private FullNameSplit fullNameSplit = new FullNameSplit();

    @Given("The full name as below")
    public void inputFullNameList(DataTable dataTable)
    {
        this.nameDataTable = dataTable.asList(String.class);
    }

 /*   @Given("The full name as below")
    public void inputFullNameList(List<String> nameDataTable)
    {
        this.nameDataTable = nameDataTable;
    }*/

    @When("invoke the full name split method")
    public void split()
    {
        nameDataTable.forEach(name ->
        {
            String[] result = fullNameSplit.split(name);
            actuallyNames.add(new Name(result[0], result[1]));
        });
    }

    @Then("the split result as below")
    public void verify(DataTable dataTable)
    {
        List<Name> exceptedNameList = dataTable.asList(Name.class);
        assertThat(exceptedNameList, hasSize(4));
        for (int i = 0; i < exceptedNameList.size(); i++)
        {
            Name exceptedName = exceptedNameList.get(i);
            Name actuallyName = actuallyNames.get(i);
            assertThat(actuallyName.getFirstName(), either(equalTo(exceptedName.getFirstName())).or(equalTo("")));
            assertThat(actuallyName.getLastName(), either(equalTo(exceptedName.getLastName())).or(equalTo("")));
        }
    }

/*    @Then("the split result as below")
    public void verify(List<Name> exceptedNameList)
    {
        assertThat(exceptedNameList, hasSize(4));
        for (int i = 0; i < exceptedNameList.size(); i++)
        {
            Name exceptedName = exceptedNameList.get(i);
            Name actuallyName = actuallyNames.get(i);
            assertThat(actuallyName.getFirstName(), either(equalTo(exceptedName.getFirstName())).or(equalTo("")));
            assertThat(actuallyName.getLastName(), either(equalTo(exceptedName.getLastName())).or(equalTo("")));
        }
    }*/

    @DataTableType
    public Name nameType(Map<String, String> entry)
    {
        return new Name(entry.get("firstName"), entry.get("lastName"));
    }

    static class Name
    {
        private String firstName;
        private String lastName;

        public Name(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Name()
        {
        }

        public String getFirstName()
        {
            return firstName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        @Override
        public String toString()
        {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
