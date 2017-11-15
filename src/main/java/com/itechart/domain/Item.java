package com.itechart.domain;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iditem")
    private Integer id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private Integer price;

    @Column(name = "item_type")
    @Convert(converter = TypeConverter.class)
    private Type type;

    public enum Type {
        COUNT,
        VOLUME
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!id.equals(item.id)) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        return type != null ? type.equals(item.type) : item.type == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", type='" + type + '\'' +
            '}';
    }

    @Convert
    private class TypeConverter implements AttributeConverter<Type, String> {

        @Override
        public String convertToDatabaseColumn(Type attribute) {
            switch (attribute) {
                case COUNT:
                    return "C";
                case VOLUME:
                    return "V";
                default:
                    throw new IllegalArgumentException("Unknown " + attribute);
            }
        }

        @Override
        public Type convertToEntityAttribute(String dbData) {
            switch (dbData) {
                case "C":
                    return Type.COUNT;
                case "V":
                    return Type.VOLUME;
                default:
                    throw new IllegalArgumentException("Unknown " + dbData);
            }
        }
    }
}
