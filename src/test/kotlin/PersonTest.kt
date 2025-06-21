import nl.novi.Person
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PersonTest {

    // We gebruiken hier lateinit, omdat we de objecten gegarandeerd in de @BeforeEach zetten.
    lateinit var person: Person
    lateinit var johnDoe: Person

    // Deze methode runt voorafgaand aan elke test, door de BeforeEach annotatie.
    // Deze methode is dus ideaal voor het opzetten van testdata, zodat je dat niet in elke test opnieuw hoeft te doen.
    @BeforeEach
    fun setUp() {
        person = Person("testman")
        johnDoe = Person()
    }

    @Test
    fun getname() {
            //Arrange (setUp())
            //Act
            val result = person.name
            //Assert
            assertEquals("testman", result)
        }

    @Test
    fun nameShouldNotBeChangedDuringCreation() {
        //Arrange (setUp())
        //Act
        //Assert
        assertEquals("testman", person.name)
    }

    @Test
    fun personWithoutNameShouldBeNamedJohn() {
        //Arrange (setUp())
        //Act
        val result = johnDoe.name
        //Assert
        assertEquals("John", result)
        assertEquals("Doe", johnDoe.lastName)
    }

    @Test
    fun setName() {
        //Arrange (setUp())
        //Act
        person.name = "novi"
        val result = person.name
        //Assert
        assertEquals("novi", result)
    }

    @Test
    fun lastNameIsNull() {
            //Arrange (setUp())
            //Act
            val result = person.lastName
            //Assert
            assertNull(result)
        }

    @Test
    fun setLastName() {
        //Arrange (setUp())
        //Act
        person.lastName = "Jansen"
        val result = person.lastName
        //Assert
        assertEquals("Jansen", result)
    }

    @Test
    fun lastNameShouldShouldStartWithUpperCaseWhenLowerCaseGiven() {
        //Arrange (setUp())
        //Act
        person.lastName = "lastname"
        val result = person.lastName
        //Assert
        assertEquals("Lastname", result)
    }

    @Test
    fun ageIsNull() {
            //Arrange (setUp())
            //Act
            val result = person.age
            //Assert
            assertEquals(0, result)
        }

    @Test
    fun setAge() {
        //Arrange (setUp())
        //Act
        person.age = 1
        val result = person.age
        //Assert
        assertEquals(1, result)
    }

    @Test
    fun ageShouldAddOneYear() {
        //Arrange (setUp())
        person.age = 1
        //Act
        person.age()
        val result = person.age
        //Assert
        assertEquals(2, result)
    }

    @Test
    fun getPartner() {
            // Voor de assert in deze methode moet je in de Person class de equals() methode hebben overschreven.
            //Arrange (setUp())
            person.partner = johnDoe
            //Act
            val result = person.partner
            //Assert
            assertEquals(johnDoe, result)
        }

    @Test
    fun setPartner() {
        //Arrange (setUp())
        //Act
        person.partner = johnDoe
        val result = person.partner
        //Assert
        assertEquals(johnDoe, result)
    }

    @Test
    fun givenNoPartnerHasPartnerShouldReturnFalse() {
        //Arrange (setUp())
        //Act
        val result = person.hasPartner()
        //Assert
        assertFalse(result)
    }

    @Test
    fun givenAPartnerHasPartnerShouldReturnTrue() {
        //Arrange (setUp())
        person.partner = johnDoe
        //Act
        val result = person.hasPartner()
        //Assert
        assertTrue(result)
    }

    @Test
    fun childShouldBeAddedToList() {
        //Arrange (setUp())
        //Act
        person.addChild(johnDoe)
        val result: List<Person> = person.getChildren()
        //Assert
        assertEquals(java.util.List.of(johnDoe), result)
    }

    @Test
    fun shouldNotAddChildWithSameName() {
        //Arrange (setUp())
        person.addChild(johnDoe)
        person.addChild(johnDoe)
        //Act
        val result: List<Person> = person.getChildren()
        //Assert
        assertEquals(java.util.List.of(johnDoe), result)
    }

    @Test
    fun setChildren() {
        //Arrange (setUp())
        val child = Person("child")
        val toAdd: MutableList<Person> = ArrayList()
        toAdd.add(johnDoe)
        toAdd.add(child)
        //Act
        person.setChildren(toAdd.toList())
        val result: List<Person> = person.getChildren()
        //Assert
        assertEquals(toAdd, result)
    }
}