package mindtech.homework.pokemonassignment.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey
    val id: Long,
    val name: String,
    val baseExperience: Long,
    val height: Long,
    val isDefault: Boolean,
    val order: Long,
    val weight: Long,
    val abilities: List<Ability>,
    val forms: List<Form>,
    val gameIndices: List<Index>,
    val heldItems: List<HeldItem>,
    val locationAreaEncounters: String,
    val moves: List<Mfe>,
    val species: Species,
    val sprites: Sprites,
    val cries: Cries,
    val stats: List<Stat>,
    val types: List<Type>,
    val pastTypes: List<PastType>,
)

data class Ability(
    val isHidden: Boolean,
    val slot: Long,
    val ability: Ability2,
)
data class Ability2(
    val name: String,
    val url: String,
)
data class Form(
    val name: String,
    val url: String,
)
data class Index(
    val gameIndex: Long,
    val version: Version,
)
data class Version(
    val name: String,
    val url: String,
)
data class HeldItem(
    val item: Item,
    val versionDetails: List<VersionDetail>,
)
data class Item(
    val name: String,
    val url: String,
)
data class VersionDetail(
    val rarity: Long,
    val version: Version2,
)
data class Version2(
    val name: String,
    val url: String,
)
data class Mfe(
    val move: Move,
    val versionGroupDetails: List<VersionGroupDetail>,
)
data class Move(
    val name: String,
    val url: String,
)
data class VersionGroupDetail(
    val levelLearnedAt: Long,
    val versionGroup: VersionGroup,
    val moveLearnMethod: MoveLearnMethod,
)
data class VersionGroup(
    val name: String,
    val url: String,
)
data class MoveLearnMethod(
    val name: String,
    val url: String,
)
data class Species(
    val name: String,
    val url: String,
)
data class Sprites(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
    val other: Other,
    val versions: Versions,
)
data class Other(
    val dreamWorld: DreamWorld,
    val home: Home,
    val officialArtwork: OfficialArtwork,
    val showdown: Showdown,
)
data class DreamWorld(
    val frontDefault: String,
    val frontFemale: Any?,
)
data class Home(
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class OfficialArtwork(
    val frontDefault: String,
    val frontShiny: String,
)
data class Showdown(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class Versions(
    val generationI: GenerationI,
    val generationIi: GenerationIi,
    val generationIii: GenerationIii,
    val generationIv: GenerationIv,
    val generationV: GenerationV,
    val generationVi: GenerationVi,
    val generationVii: GenerationVii,
    val generationViii: GenerationViii,
)
data class GenerationI(
    val redBlue: RedBlue,
    val yellow: Yellow,
)
data class RedBlue(
    val backDefault: String,
    val backGray: String,
    val frontDefault: String,
    val frontGray: String,
)
data class Yellow(
    val backDefault: String,
    val backGray: String,
    val frontDefault: String,
    val frontGray: String,
)
data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver,
)
data class Crystal(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
)
data class Gold(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
)
data class Silver(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
)
data class GenerationIii(
    val emerald: Emerald,
    val fireredLeafgreen: FireredLeafgreen,
    val rubySapphire: RubySapphire,
)
data class Emerald(
    val frontDefault: String,
    val frontShiny: String,
)
data class FireredLeafgreen(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
)
data class RubySapphire(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
)
data class GenerationIv(
    val diamondPearl: DiamondPearl,
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum,
)
data class DiamondPearl(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class HeartgoldSoulsilver(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class Platinum(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class GenerationV(
    val blackWhite: BlackWhite,
)
data class BlackWhite(
    val animated: Animated,
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class Animated(
    val backDefault: String,
    val backFemale: Any?,
    val backShiny: String,
    val backShinyFemale: Any?,
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class GenerationVi(
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    val xY: XY,
)
data class OmegarubyAlphasapphire(
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class XY(
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class GenerationVii(
    val icons: Icons,
    val ultraSunUltraMoon: UltraSunUltraMoon,
)
data class Icons(
    val frontDefault: String,
    val frontFemale: Any?,
)
data class UltraSunUltraMoon(
    val frontDefault: String,
    val frontFemale: Any?,
    val frontShiny: String,
    val frontShinyFemale: Any?,
)
data class GenerationViii(
    val icons: Icons2,
)
data class Icons2(
    val frontDefault: String,
    val frontFemale: Any?,
)
data class Cries(
    val latest: String,
    val legacy: String,
)
data class Stat(
    val baseStat: Long,
    val effort: Long,
    val stat: Stat2,
)
data class Stat2(
    val name: String,
    val url: String,
)
data class Type(
    val slot: Long,
    val type: Type2,
)
data class Type2(
    val name: String,
    val url: String,
)
data class PastType(
    val generation: Generation,
    val types: List<Type3>,
)
data class Generation(
    val name: String,
    val url: String,
)
data class Type3(
    val slot: Long,
    val type: Type4,
)
data class Type4(
    val name: String,
    val url: String,
)
