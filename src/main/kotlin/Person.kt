package nl.novi

class Person// Constructor met naam
    (var name: String = "Joe") {
    var lastName: String = "Doe"
        set(value) {
            field = if (isFirstLetterUpperCase(value)) {
                value
            } else {
                value.substring(0, 1).uppercase() + value.substring(1).lowercase()
            }
        }
    var age: Int = 0

    var partner: Person? = null

    private val children = mutableListOf<Person>()


    private fun isFirstLetterUpperCase(value: String): Boolean {
        return value.isNotEmpty() && value[0].isUpperCase()
    }

    fun age() {
        this.age++
    }

    fun hasPartner(): Boolean {
        return partner != null
    }

    fun addChild(child: Person) {
        if (hasUniqueName(child)) {
            children.add(child)
        }
    }

    private fun hasUniqueName(child: Person): Boolean {
        return children.none { it.name.equals(child.name, ignoreCase = true) }
    }

    fun getChildren(): MutableList<Person> {
        return children
    }

    fun setChildren(newChildren: List<Person>) {
        children.clear()
        children.addAll(newChildren)
    }

}