rootProject.name = "alex-project"

include(
        "alex-common"
)

rootProject.children.forEach {
    it.name = it.name.replace("/", "-")
}
