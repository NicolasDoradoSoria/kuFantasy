package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Item
import org.springframework.stereotype.Component

@Component
class ItemRepository : Repository<Item>()