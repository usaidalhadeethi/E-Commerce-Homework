//package com.spring1.trendyol_odevi.basket.impl;
//
//import com.spring1.trendyol_odevi.Product.impl.Product;
//import com.spring1.trendyol_odevi.Product.impl.ProductServiceImpl;
//import com.spring1.trendyol_odevi.basket.api.BasketDTO;
//import com.spring1.trendyol_odevi.basket.api.BasketService;
//import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
//import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProductServiceImpl;
//import com.spring1.trendyol_odevi.basket.web.BasketRequest;
//import com.spring1.trendyol_odevi.user.impl.User;
//import com.spring1.trendyol_odevi.user.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class BasketServiceImpl implements BasketService {
//
//    @Autowired
//    private BasketRepository repository;
//
//    @Autowired
//    private ProductServiceImpl productService;
//
//    @Autowired
//    private BasketProductServiceImpl basketProductService;
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    private final int BASKET_STATUS_NONE = 0;
//    private final int BASKET_STATUS_SALE = 1;
//    private final int BASKET_STATUS_DELIVERED = 2;
//    private final int BASKET_STATUS_CANCELED = 3;
//
//    @Override
//    public BasketDTO addProductToBasket(int productId, String userId) {
//        // Find or create basket for user
//        User user = userService.findById(userId);
//        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
//
//        if (basket == null) {
//            // Create a new basket if one doesn't exist
//            basket = createNewBasket(user, productId);
//        } else {
//            // Update existing basket with the new product
//            basket.setBasketProducts(updateBasket(basket, productId, 1)); // 1 is the default count, modify as needed
//        }
//
//        // Save updated basket
//        basket = repository.save(basket);
//        return toDto(basket);
//    }
//
//    @Override
//    public BasketDTO findByUser(User user) {
//        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
//        return toDto(basket);
//    }
//
//    public BasketDTO saveBasket(BasketRequest request) {
//        User user = userService.findById(request.getUserId());
//        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
//
//        if (basket == null) {
//            basket = createNewBasket(user, request);
//            basket = repository.save(basket);
//        } else {
//            basket.setBasketProducts(updateBasket(basket, request));
//            basket.setBasketAmount(calcTotalBasketAmount(basket));
//            basket = repository.save(basket);
//        }
//
//        return BasketProductServiceImpl.toDto(basket);
//    }
//
//    public List<BasketProduct> updateBasket(Basket basket, BasketRequest request) {
//        BasketProduct basketProduct = basketProductService.findByProductId(request.productId);
//
//        if (basketProduct != null) {
//            for (BasketProduct product : basket.getBasketProducts()) {
//                if (product.getProduct().getId() == request.productId) {
//                    product.setTotalBasketProductCount(product.getTotalBasketProductCount() + request.count);
//                    product.setBasketProductAmount(product.getProduct().getPrice() * product.getTotalBasketProductCount());
//                }
//            }
//            return basket.getBasketProducts();
//        } else {
//            basket.getBasketProducts().add(createBasketProduct(request.productId, request.count));
//            return basket.getBasketProducts();
//        }
//    }
//
//    public BasketProduct createBasketProduct(int productID, int count) {
//        Product product = productService.findById(productID);
//        BasketProduct newBasketProduct = new BasketProduct();
//        newBasketProduct.setProduct(product);
//        newBasketProduct.setCount(count);
//        newBasketProduct.setBasketProductAmount(product.getPrice() * newBasketProduct.getCount());
//        return newBasketProduct;
//    }
//
//    public Basket createNewBasket(User user, BasketRequest request) {
//        Basket basket = new Basket();
//        basket.setUser(user);
//        basket.setStatus(BASKET_STATUS_NONE);
//        basket.setBasketProducts(List.of(createBasketProduct(request.getProductId(), request.count)));
//        basket.setBasketAmount(calcTotalBasketAmount(basket));
//        return basket;
//    }
//
//    public double calcTotalBasketAmount(Basket basket) {
//        double amount = 0;
//        for (BasketProduct basketProduct : basket.getBasketProducts()) {
//            amount += basketProduct.getBasketProductAmount();
//        }
//        return amount;
//    }
//
//    public static Basket toEntity(BasketDTO dto) {
//        return Basket.builder()
//                .id(dto.getId())
//                .basketProducts(basketProductService.toDtoList())
//                .totalBasketAmount(dto.getTotalBasketAmount())
//                .status(dto.getStatus())
//                .user(UserServiceImpl.toEntity(dto.getUser()))
//                .build();
//    }
//
//    public static BasketDTO toDto(Basket basket) {
//        return BasketDTO.builder()
//                .id(basket.getId())
//                .basketProducts()
//                .totalBasketAmount(basket.getTotalBasketAmount())
//                .status(basket.getStatus())
//                .user(UserServiceImpl.toDto(basket.getUser()))
//                .build();
//    }
//
//    public static List<BasketDTO> toDtoList(List<Basket> basketList) {
//        return basketList.stream()
//                .map(BasketProductServiceImpl::toDto)
//                .collect(Collectors.toList());
//    }
//
//}
package com.spring1.trendyol_odevi.basket.impl;

import com.spring1.trendyol_odevi.Product.impl.Product;
import com.spring1.trendyol_odevi.Product.impl.ProductServiceImpl;
import com.spring1.trendyol_odevi.basket.api.BasketDTO;
import com.spring1.trendyol_odevi.basket.api.BasketService;
import com.spring1.trendyol_odevi.basket.basketProduct.api.BasketProductDTO;
import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProductServiceImpl;
import com.spring1.trendyol_odevi.basket.web.BasketRequest;
import com.spring1.trendyol_odevi.user.api.UserDTO;
import com.spring1.trendyol_odevi.user.impl.User;
import com.spring1.trendyol_odevi.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository repository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private BasketProductServiceImpl basketProductService;

    @Autowired
    private UserServiceImpl userService;

    private final int BASKET_STATUS_NONE = 0;
    private final int BASKET_STATUS_SALE = 1;
    private final int BASKET_STATUS_DELIVERED = 2;
    private final int BASKET_STATUS_CANCELED = 3;

    @Override
    public BasketDTO addProductToBasket(int productId, String userId) {
        // Find or create basket for user
        User user = userService.findById(userId);
        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);

        if (basket == null) {
            basket = createNewBasket(user, new BasketRequest());
        } else {
            basket.setBasketProducts(updateBasket(basket, new BasketRequest()));
        }

        // Save updated basket
        basket = repository.save(basket);
        return toDto(basket);
    }

    @Override
    public BasketDTO findByUser(User user) {
        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);
        return toDto(basket);
    }

    public BasketDTO saveBasket(BasketRequest request) {
        User user = userService.findById(request.getUserId());
        Basket basket = repository.findByUserAndStatus(user, BASKET_STATUS_NONE);

        if (basket == null) {
            basket = createNewBasket(user, request);
            basket = repository.save(basket);
        } else {
            basket.setBasketProducts(updateBasket(basket, request));
            basket.setBasketAmount(calcTotalBasketAmount(basket));
            basket = repository.save(basket);
        }

        return toDto(basket);
    }

    public List<BasketProduct> updateBasket(Basket basket, BasketRequest request) {
        BasketProductDTO basketProduct = basketProductService.findById(String.valueOf(request.getProductId()));

        if (basketProduct != null) {
            for (BasketProduct product : basket.getBasketProducts()) {
                if (product.getProduct().getProductId().equals(request.getProductId())) {
                    product.setCount(product.getCount() + request.getBasketProducts().getFirst().getCount());
                    product.setBasketProductAmount(product.getProduct().getPrice() * product.getCount());
                }
            }
            return basket.getBasketProducts();
        } else {
            basket.getBasketProducts().add(createBasketProduct(request.getProductId(), request.getBasketProducts().getFirst().getCount()));
            return basket.getBasketProducts();
        }
    }

    public BasketProduct createBasketProduct(int productID, int count) {
        Product product = productService.findById(String.valueOf(productID));
        BasketProduct newBasketProduct = new BasketProduct();
        newBasketProduct.setProduct(product);
        newBasketProduct.setCount(count);
        newBasketProduct.setBasketProductAmount(product.getPrice() * newBasketProduct.getCount());
        return newBasketProduct;
    }

    public Basket createNewBasket(User user, BasketRequest request) {
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setStatus(BASKET_STATUS_NONE);
        basket.setBasketProducts(List.of(createBasketProduct(request.getProductId(), request.getBasketProducts().getFirst().getCount())));
        basket.setBasketAmount(calcTotalBasketAmount(basket));
        return basket;
    }

    public float calcTotalBasketAmount(Basket basket) {
        double amount = 0;
        for (BasketProduct basketProduct : basket.getBasketProducts()) {
            amount += basketProduct.getBasketProductAmount();
        }
        return (float) amount;
    }

    @Override
    public Basket toEntity(BasketDTO basketDTO) {
        Basket basket = new Basket();
        basket.setBasketId(basketDTO.getBasketId());
        basket.setBasketAmount(basketDTO.getBasketAmount());
        basket.setStatus(BASKET_STATUS_NONE);
        List<BasketProduct> basketProducts = basketDTO.getBasketProducts().stream()
                .map(basketProductDTO -> basketProductService.toEntity(basketProductDTO))
                .collect(Collectors.toList());
        basket.setBasketProducts(basketProducts);
        User user = userService.toEntity(new UserDTO());
        basket.setUser(user);

        return basket;
    }


    public BasketDTO toDto(Basket basket) {
        return new BasketDTO.Builder()
                .basketId(basket.getBasketId())
                .basketProducts(basketProductService.toDtoList(basket.getBasketProducts()))
                .basketAmount(basket.getBasketAmount())
                .userId(basket.getUser().getUserId())
                .build();
    }

    public List<BasketDTO> toDtoList(List<Basket> basketList) {
        return basketList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
