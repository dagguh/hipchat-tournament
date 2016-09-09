package pl.dagguh.tournaments.tournament

import pl.dagguh.tournaments.channel.ChannelEntity
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class TournamentEntity(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var title: String = "",
        @ManyToOne
        var channel: ChannelEntity? = null
) : Serializable {

    fun toViewDto(): TournamentViewDto {
        return TournamentViewDto(
                id = id!!,
                title = title,
                channel = channel!!.toViewDto()
        )
    }
}