package nl.novi

class Person// Constructor met naam
    (var name: String) {
    var lastName: String? = null
        set(value) {
            field = if (value?.let { isFirstLetterUpperCase(it) } ?: true) {
                value
            } else {
                // Je mag er hier van uit gaan dat value niet-null is, vanwege de let hierboven
                value!!.substring(0, 1).uppercase() + value.substring(1).lowercase()
            }
        }
    constructor() : this("John"){
        this.lastName = "Doe"
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